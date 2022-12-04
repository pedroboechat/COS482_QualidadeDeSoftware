package com.ufrj.cos482.delegate;

import com.ufrj.cos482.service.MailService;
import com.ufrj.cos482.service.dto.JudicialProcedureDTO;
import com.ufrj.cos482.service.dto.JudicialProcedureProcessDTO;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import java.util.Locale;

@Component
public class ProtocolateProcessDelegate implements JavaDelegate {

    @Autowired
    MailService mailService;

    @Autowired
    SpringTemplateEngine templateEngine;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        JudicialProcedureProcessDTO JudicialProcedureProcess = (JudicialProcedureProcessDTO) delegateExecution.getVariable("processInstance");
        JudicialProcedureDTO JudicialProcedure = JudicialProcedureProcess.getJudicialProcedure();
        String to = "thiagoguima@poli.ufrj.br";
        String subject = "Ha um processo que necessita ser protocolado!";
        Context context = new Context(Locale.getDefault());
        context.setVariable("judicialProcedure", JudicialProcedure);
        String content = templateEngine.process("judicialProcedureProcess/protocolateJudicialProcedureEmail", context);
        mailService.sendEmail(to, subject, content, false, true);
    }
}
