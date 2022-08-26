import java.io.*; // Esta biblioteca pois utilizamos a classe File, que tem todos os comandos necessarios.
import java.util.Scanner;

public class criarArq {
    public static void main(String[] args) {
        String nome, conteudo;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do arquivo: ");
        nome = scanner.nextLine();
        // Nesta linha criamos o objeto arquivo do Tipo File, consequentemente criando o arquivo em si.
        File arquivo = new File("C:\\Users\\rriga\\OneDrive\\Desktop\\Coisas\\Facul\\Sistemas Operacionais\\ManipuladorArquivosJava\\"+ nome +".txt");
        System.out.print("Digite o que deseja escrito dentro do arquivo: ");
        conteudo = scanner.nextLine();
        try {
            // Nesta linha criamos um objeto escritor do tipo FileWriter, a partir desse objeto escrevemos
            // no arquivo.
            FileWriter escritor = new FileWriter(nome + ".txt");
            // Nesta linha estamos chamando o metodo write para escrever no arquivo, e enviando o texto
            // contido na variavel conteudo, do tipo String.
            escritor.write(conteudo);
            // Nesta linha fechamos o FileWriter pois não iremos mais usa-lo.
            escritor.close();
            // E o Try catch para caso qualquer erro ocorra tentando escrever no arquivo.
        } catch (IOException e) {
            System.out.println("Ocorreu um erro.");
            e.printStackTrace();
        }
        scanner.close();
        try{
            // Nesta linha nós criamos um Scanner, mas passamos o objeto arquivo do tipo File, pois desta
            // forma o Scanner em questão vai ler o File arquivo.
            Scanner arquivoScan = new Scanner(arquivo);
            // Um while que ira ler o File arquivo até que ele acabe.
            while (arquivoScan.hasNextLine()) {
                String conteudoRetirado = arquivoScan.nextLine();
                System.out.println(conteudoRetirado);
            }
            arquivoScan.close();
            // E o Try catch para caso qualquer erro ocorra tentando recuperar as informações do arquivo.
        } catch(FileNotFoundException e){
            System.out.println("Ocorreu um erro.");
            e.printStackTrace();
        }
    }
}
