FROM agilekip/generator-jhipster-agilekip:v0.0.12

USER root

RUN apt-get update

RUN apt-get install -y openjdk-11-jdk

USER jhipster
