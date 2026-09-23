public class MenuAluno {

    private int opc;
    private Aluno aluno;
    private EntradaSaidaDados entOuSai;
    private CinversorNumeros convert;

    public MenuAluno(){
        this.aluno = new Aluno();
        this.convert = new CinversorNumeros();
        this.entOuSai = new EntradaSaidaDados();
        this.opc = -1;
    }

    public void executarSistema(){
        do {
            this.mostrarMenu();
            this.avaliarOpcEscolhida();
        }
        while (opc != 0);
    }

    public void mostrarMenu(){

        String mensagemMenu = "Selecione uma opção "
                + "\n 1 - Cadastrar minhas notas!"
                + "\n 2 - Conferir média!"
                + "\n 3 - Conferir aprovação!"
                + "\n 4 - Sair";

        String receberOpc = entOuSai.entradaDados(mensagemMenu);
        this.opc =convert.StringToInt(receberOpc);
    }

    public void avaliarOpcEscolhida(){

        double nota1 = 0, nota2 = 0, nota3 = 0, media = 0;

        if (this.opc > 0 && opc <= 4){

            switch (this.opc){

                case 1:
                    nota1 = convert.StringToDouble(entOuSai.entradaDados("Digite a sua primeira nota: "));
                    aluno.setNota1(nota1);

                    nota2 = convert.StringToDouble(entOuSai.entradaDados("Digite a sua segunda nota: "));
                    aluno.setNota2(nota2);

                    nota3 = convert.StringToInt(entOuSai.entradaDados("Digite a sua terceira nota: "));
                    aluno.setNota3(nota3);

                    aluno.calcularMedia();
                    break;

                case 2:
                    if (aluno.getConferirMedia() == 1){
                        entOuSai.saidaDados("Sua média é: " +String.format("%.2f", aluno.getMedia()));

                    } else entOuSai.saidaDados("Ops! Você ainda não digitou sua notas :|");
                    break;

                case 3:

                    if (aluno.getConferirMedia() == 1) {
                        if (aluno.getMedia() >= 7) {
                            entOuSai.saidaDados("Parabéns! Você foi aprovado :)");
                        } else {
                            entOuSai.saidaDados("Que triste! Você foi reprovado :(");
                        }

                    }else {
                        entOuSai.saidaDados("Ops! Você ainda não digitou suas notas! ");
                    }

                    break;


                case 4:
                    aluno.sair();
                    break;
            }
        }
    }
}
