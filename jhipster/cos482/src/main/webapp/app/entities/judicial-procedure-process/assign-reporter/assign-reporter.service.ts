import axios from 'axios';
import { AssignReporterContext } from './assign-reporter.model';

const baseApiUrl = 'api/judicial-procedure-process/assign-reporter';

export default class AssignReporterService {
  public loadContext(taskId: number): Promise<AssignReporterContext> {
    return new Promise<AssignReporterContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<AssignReporterContext> {
    return new Promise<AssignReporterContext>((resolve, reject) => {
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

  public complete(assignReporterContext: AssignReporterContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, assignReporterContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
