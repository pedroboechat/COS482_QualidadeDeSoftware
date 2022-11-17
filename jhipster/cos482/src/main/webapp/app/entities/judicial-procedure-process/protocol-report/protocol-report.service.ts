import axios from 'axios';
import { ProtocolReportContext } from './protocol-report.model';

const baseApiUrl = 'api/judicial-procedure-process/protocol-report';

export default class ProtocolReportService {
  public loadContext(taskId: number): Promise<ProtocolReportContext> {
    return new Promise<ProtocolReportContext>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${taskId}`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public claim(taskId: number): Promise<ProtocolReportContext> {
    return new Promise<ProtocolReportContext>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${taskId}/claim`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public complete(protocolReportContext: ProtocolReportContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, protocolReportContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
