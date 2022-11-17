import axios from 'axios';

import { IJudicialProcedureProcess } from '@/shared/model/judicial-procedure-process.model';

const baseApiUrl = 'api/judicial-procedure-processes';

export default class JudicialProcedureProcessService {
  public find(id: number): Promise<IJudicialProcedureProcess> {
    return new Promise<IJudicialProcedureProcess>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${id}`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public retrieve(): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .get(baseApiUrl)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public create(entity: IJudicialProcedureProcess): Promise<IJudicialProcedureProcess> {
    return new Promise<IJudicialProcedureProcess>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}`, entity)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
