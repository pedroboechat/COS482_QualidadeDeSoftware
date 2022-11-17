import axios from 'axios';
import { AssignReportContext } from './assign-report.model';

const baseApiUrl = 'api/judicial-procedure-process/assign-report';

export default class AssignReportService {
  public loadContext(taskId: number): Promise<AssignReportContext> {
    return new Promise<AssignReportContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<AssignReportContext> {
    return new Promise<AssignReportContext>((resolve, reject) => {
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

  public complete(assignReportContext: AssignReportContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, assignReportContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
