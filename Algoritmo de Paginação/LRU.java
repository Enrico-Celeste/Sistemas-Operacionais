public class LRU {
    public static void main(String[] args) {
        int[] sequencia = { 10, 1, 7, 2, 3, 2, 7, 1, 10, 3 }, ram = new int[4];
        int pagina, sequenciaN = 0, pageFault = 0;
        int t0 = 0, t1 = 0, t2 = 0, t3 = 0;
        for (pagina = 0; pagina < 8; pagina++) {
            if (pagina > 0) {
                t0 = 0;
                t1 = 0;
                t2 = 0;
                t3 = 0;
                for (int y = 0; y < 4; y++) {
                    if(sequenciaN-1 == -1)
                        sequenciaN = 10;
                    for (int x = sequenciaN-1; x < 10; x--) {
                        if (ram[0] != sequencia[x])
                            t0++;
                        else
                            break;
                        if (x == 0)
                            x = 9;
                    }
                    for (int x = sequenciaN-1; x < 10; x--) {
                        if (ram[1] != sequencia[x])
                            t1++;
                        else
                            break;
                        if (x == 0)
                            x = 9;
                    }
                    for (int x = sequenciaN-1; x < 10; x--) {
                        if (ram[2] != sequencia[x])
                            t2++;
                        else
                            break;
                        if (x == 0)
                            x = 9;
                    }
                    for (int x = sequenciaN-1; x < 10; x--) {
                        if (ram[3] != sequencia[x])
                            t3++;
                        else
                            break;
                        if (x == 0)
                            x = 9;
                    }
                    //System.out.println(t0);
                    //System.out.println(t1);
                    //System.out.println(t2);
                    //System.out.println(t3);
                    if (t0 > t1 && t0 > t2 && t0 > t3) {
                        if (ram[0] != sequencia[sequenciaN-1])
                            pageFault++;
                        ram[0] = sequencia[sequenciaN-1];
                        if (sequenciaN != 0)
                            sequenciaN--;
                        else
                            sequenciaN = 10;
                        System.out.println("RAM:([" + ram[0] + "][" + ram[1] + "][" + ram[2] + "][" + ram[3] + "])");
                    } else if (t1 > t0 && t1 > t2 && t1 > t3) {
                        if (ram[1] != sequencia[sequenciaN-1])
                            pageFault++;
                        ram[1] = sequencia[sequenciaN-1];
                        if (sequenciaN != 0)
                            sequenciaN--;
                        else
                            sequenciaN = 10;
                        System.out.println("RAM:([" + ram[0] + "][" + ram[1] + "][" + ram[2] + "][" + ram[3] + "])");
                    } else if (t2 > t0 && t2 > t1 && t2 > t3) {
                        if (ram[2] != sequencia[sequenciaN-1])
                            pageFault++;
                        ram[2] = sequencia[sequenciaN-1];
                        if (sequenciaN != 0)
                            sequenciaN--;
                        else
                            sequenciaN = 10;
                        System.out.println("RAM:([" + ram[0] + "][" + ram[1] + "][" + ram[2] + "][" + ram[3] + "])");
                    } else {
                        if (ram[3] != sequencia[sequenciaN-1])
                            pageFault++;
                        ram[3] = sequencia[sequenciaN-1];
                        if (sequenciaN != 0)
                            sequenciaN--;
                        else
                            sequenciaN = 10;
                        System.out.println("RAM:([" + ram[0] + "][" + ram[1] + "][" + ram[2] + "][" + ram[3] + "])");
                    }
                }
            } else {
                for (int x = 0; x < 4; x++) {
                    if (ram[x] != sequencia[sequenciaN])
                        pageFault++;
                    ram[x] = sequencia[sequenciaN];
                    if (sequenciaN != 9)
                        sequenciaN++;
                    else
                        sequenciaN = 0;
                    System.out.println("RAM:([" + ram[0] + "][" + ram[1] + "][" + ram[2] + "][" + ram[3] + "])");
                }
                sequenciaN = 0;
            }
        }
        System.out.println(pageFault + " Page faults");
    }
}