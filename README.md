Projeto de Sistema de Gerenciamento de Tecnologias Aprendidas por Estudantes

Bem-vindo ao projeto tech-trackr! Este é um projeto pessoal criado com o objetivo de permitir que estudantes acompanhem e gerenciem as tecnologias que aprenderam ao longo de suas jornadas. Além disso, o projeto inclui uma implementação de autenticação JWT em Java para proteger os dados e recursos.

## Funcionalidades
- Registro e Autenticação de Usuário: Os estudantes podem se registrar e autenticar no sistema usando JWT tokens.
- Adição de Tecnologias: Os usuários autenticados podem adicionar as tecnologias que aprenderam ao longo do tempo. Cada tecnologia é associada a um nome e seu conhecimento.
- Exclusão de Tecnologias: Os usuários também têm a capacidade de remover tecnologias da lista.
- Listagem de Tecnologias: Os estudantes podem visualizar a lista de tecnologias que eles adicionaram, juntamente com suas descrições.

## Tecnologias Utilizadas
- Linguagem de Programação: Java
- Framework: Spring Boot
- Autenticação: JWT (JSON Web Tokens)
- Banco de Dados: PostgreSQL
- Ferramenta de Construção: Maven

## Instruções de Uso
Clone este repositório para sua máquina local.
1. Faça o clone da do repósitorio e acesse a pasta clonada.
```shell
git clone https://github.com/brenofigueiredoo/tech-trackr.git

cd tech-trackr
```
2. No arquivo application.properties configure as propriedades do banco de dados e outras configurações necessárias.

3. Rode a aplicação
```
mvn spring-boot:run
```
