import axios from 'axios';
import { ValidateReportContext } from './validate-report.model';

const baseApiUrl = 'api/judicial-procedure-process/validate-report';

export default class ValidateReportService {
  public loadContext(taskId: number): Promise<ValidateReportContext> {
    return new Promise<ValidateReportContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<ValidateReportContext> {
    return new Promise<ValidateReportContext>((resolve, reject) => {
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

  public complete(validateReportContext: ValidateReportContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, validateReportContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
