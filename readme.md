# Sistema de Matrículas

## Descrição Geral do Sistema
Uma universidade pretende informatizar seu sistema de matrículas. A secretaria da universidade gera o currículo para cada semestre e mantém as informações sobre as disciplinas, professores e alunos.

Cada curso tem um nome, um determinado número de créditos e é constituído por diversas disciplinas. Os alunos podem se matricular em 4 disciplinas como 1ª opção (obrigatórias) e em mais 2 outras alternativas (optativas).

Há períodos para efetuar matrículas, durante os quais um aluno pode acessar o sistema para se matricular em disciplinas e/ou para cancelar matrículas feitas anteriormente. Uma disciplina só fica ativa, isto é, só vai ocorrer no semestre seguinte se, no final do período de matrículas, tiver pelo menos 3 alunos inscritos (matriculados). Caso contrário, a disciplina será cancelada. O número máximo de alunos inscritos em uma disciplina é de 60 e, quando este número é atingido, as inscrições (matrículas) para essa disciplina são encerradas.

Após um aluno se inscrever para um semestre, o sistema de cobranças é notificado pelo sistema de matrículas, de modo que o aluno possa ser cobrado pelas disciplinas daquele semestre. Os professores podem acessar o sistema para saber quais são os alunos que estão matriculados em cada disciplina.

Todos os usuários do sistema têm senhas que são utilizadas para validação do respectivo login.

## Funcionalidades Principais
- **Gestão de Cursos:** Administração dos cursos oferecidos pela universidade, incluindo nome e número de créditos.
- **Gestão de Disciplinas:** Administração das disciplinas, incluindo nome, professor responsável e número de alunos matriculados.
- **Gestão de Alunos:** Administração dos dados dos alunos e suas matrículas.
- **Períodos de Matrícula:** Definição de períodos específicos para a realização de matrículas e cancelamentos.
- **Notificações de Cobrança:** Integração com o sistema de cobranças para notificação de matrículas.
- **Validação de Login:** Sistema de autenticação para acesso seguro dos usuários.

## Tecnologias Utilizadas
- **Backend:** Java.
- **Frontend:** .....
- **Banco de Dados:** MySQL.
- **Autenticação:** .....