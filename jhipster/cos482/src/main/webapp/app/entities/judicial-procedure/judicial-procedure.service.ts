import axios from 'axios';

import { IJudicialProcedure } from '@/shared/model/judicial-procedure.model';

const baseApiUrl = 'api/judicial-procedures';

export default class JudicialProcedureService {
  public find(id: number): Promise<IJudicialProcedure> {
    return new Promise<IJudicialProcedure>((resolve, reject) => {
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
}
