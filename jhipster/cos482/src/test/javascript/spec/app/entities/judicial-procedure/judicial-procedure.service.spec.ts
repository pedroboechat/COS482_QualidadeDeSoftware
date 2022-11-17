/* tslint:disable max-line-length */
import axios from 'axios';
import sinon from 'sinon';
import dayjs from 'dayjs';

import { DATE_FORMAT } from '@/shared/date/filters';
import JudicialProcedureService from '@/entities/judicial-procedure/judicial-procedure.service';
import { JudicialProcedure } from '@/shared/model/judicial-procedure.model';

const error = {
  response: {
    status: null,
    data: {
      type: null,
    },
  },
};

const axiosStub = {
  get: sinon.stub(axios, 'get'),
  post: sinon.stub(axios, 'post'),
  put: sinon.stub(axios, 'put'),
  patch: sinon.stub(axios, 'patch'),
  delete: sinon.stub(axios, 'delete'),
};

describe('Service Tests', () => {
  describe('JudicialProcedure Service', () => {
    let service: JudicialProcedureService;
    let elemDefault;
    let currentDate: Date;

    beforeEach(() => {
      service = new JudicialProcedureService();
      currentDate = new Date();
      elemDefault = new JudicialProcedure(
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        false,
        'AAAAAAA',
        currentDate,
        'AAAAAAA',
        'AAAAAAA',
        false,
        currentDate
      );
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign(
          {
            DataDaVisita: dayjs(currentDate).format(DATE_FORMAT),
            ProtocoladoEm: dayjs(currentDate).format(DATE_FORMAT),
          },
          elemDefault
        );
        axiosStub.get.resolves({ data: returnedFromService });

        return service.find(123).then(res => {
          expect(res).toMatchObject(elemDefault);
        });
      });

      it('should not find an element', async () => {
        axiosStub.get.rejects(error);
        return service
          .find(123)
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of JudicialProcedure', async () => {
        const returnedFromService = Object.assign(
          {
            NumeroDoProcesso: 'BBBBBB',
            Tribunal: 'BBBBBB',
            Juiz: 'BBBBBB',
            NecessitaLaudo: true,
            Laudista: 'BBBBBB',
            DataDaVisita: dayjs(currentDate).format(DATE_FORMAT),
            Endereco: 'BBBBBB',
            LinkLaudo: 'BBBBBB',
            LaudoValido: true,
            ProtocoladoEm: dayjs(currentDate).format(DATE_FORMAT),
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            DataDaVisita: currentDate,
            ProtocoladoEm: currentDate,
          },
          returnedFromService
        );
        axiosStub.get.resolves([returnedFromService]);
        return service.retrieve().then(res => {
          expect(res).toContainEqual(expected);
        });
      });

      it('should not return a list of JudicialProcedure', async () => {
        axiosStub.get.rejects(error);

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });
    });
  });
});
