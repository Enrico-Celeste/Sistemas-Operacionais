public class FIFO {
    public static void main(String[] args) {
      int[] sequencia = {10, 1, 7, 2, 3, 2, 7, 1, 10, 3}, ram = new int[4];
      int pagina, sequenciaN = 0, pageFault = 0;
      for(pagina = 0; pagina < 8; pagina++){
        for(int x = 0; x < 4; x++){
            if(ram[x] != sequencia[sequenciaN])
                pageFault++;
            ram[x] = sequencia[sequenciaN];
            if(sequenciaN != 9)
                sequenciaN++;
            else
                sequenciaN = 0;
            System.out.println("RAM:(["+ ram[0] +"]["+ ram[1] +"]["+ ram[2] +"]["+ ram[3] +"])");
        }
      }
      System.out.println(pageFault +" Page faults");
    }
  }