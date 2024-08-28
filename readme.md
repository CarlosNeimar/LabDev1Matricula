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

## Historias de Usuarios

### História 1

Como secretário, eu quero cadastrar e atualizar informações sobre cursos e disciplinas no sistema para garantir que esteja sempre atualizado e disponível para os alunos.

### História 2

Como secretário, eu quero registrar novos professores no sistema e associá-los às disciplinas para que eles possam ser alocados adequadamente e os alunos possam saber quem leciona cada matéria. 

### História 3

Como aluno, eu quero me matricular em até 4 disciplinas obrigatórias e 2 optativas para atender aos requisitos do curso.

### História 4

Como aluno, eu quero poder cancelar a matrícula em uma disciplina para alterar minha escolha de disciplinas antes do término do período de matrícula.

### História 5

Como aluno, eu quero visualizar quais disciplinas estão ativas e disponíveis, bem como as que foram canceladas e as que faltam, para ajustar minha matrícula e escolher as melhores opções.

### História 6

Como professor, eu quero acessar a lista de alunos matriculados em minhas disciplinas para saber quem está inscrito na matéria.

### História 7

Como secretário, eu quero definir e gerenciar os períodos de matrícula para controlar quando os alunos podem se matricular ou cancelar disciplinas, garantindo um processo organizado.

### História 8
Como usuário quero poder recuperar e alterar minha senha para garantir que eu possa acessar minha conta se esquecer minha senha ou desejar alterá-la.

### História 9

Como aluno, eu quero receber notificações sobre o status de minha matrícula e quaisquer atualizações importantes relacionadas ao processo.

### História 10

Como professor, eu quero que exiba para os alunos minhas informações de contato no sistema para garantir que eles possam me alcançar facilmente e eu possa manter uma comunicação eficaz.

### História 11

Como professor, eu quero ser notificado sobre quaisquer mudanças ou atualizações nas disciplinas que eu ministro para que eu possa ajustar meus planos de aula e preparar a abordagem educacional de acordo.

----

## Diagramas

![Captura de tela 2024-08-27 212236](https://github.com/user-attachments/assets/b475a560-8e38-4f84-86ee-eeef51113c93)


Diagrama de classe: 
![Captura de tela 2024-08-22 111844](https://github.com/user-attachments/assets/f9e0bb16-97f6-472b-84aa-6642443295a4)
