#include <stdio.h>
#include <stdlib.h>
int main(void)
{
  FILE *pontArq; //cria variável ponteiro para o arquivo
  char palavra[30];
  pontArq = fopen("arquivo.txt", "w"); //abrindo o arquivo no modo escrita
  if(pontArq == NULL) //testando se o arquivo foi criado
  {
  	printf("Erro na abertura do arquivo!\n");
  	return 1;
  }
  printf("Digite seu nome para gravar no arquivo: ");
  fgets(palavra, 40, stdin);
  fprintf(pontArq, "%s", palavra); //escrevendo no arquivo
  fclose(pontArq);//fechar o arquivo
  printf("Dados gravados com sucesso!\n");
  
  pontArq = fopen("arquivo.txt", "r"); //abrindo o arquivo no modo leitura
  while(fgets(palavra, 30, pontArq) != NULL) //
  	printf("%s", palavra);
  printf("%s", "\n");
  fclose(pontArq);//fechar o arquivo
  
  system("pause");
  return(0);
}