//TRAN QUANG HAI

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class marble {
	private int n, t, w, h;
	private int[] W = new int[700];
	private int[] H = new int[700];
	private int[][] waste = new int[700][700];
 	static class Reader 
    { 
        final private int BUFFER_SIZE = 1 << 16; 
        private DataInputStream din; 
        private byte[] buffer; 
        private int bufferPointer, bytesRead; 
  
        public Reader() 
        { 
            din = new DataInputStream(System.in); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public Reader(String file_name) throws IOException 
        { 
            din = new DataInputStream(new FileInputStream(file_name)); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public String readLine() throws IOException 
        { 
            byte[] buf = new byte[64]; // line length 
            int cnt = 0, c; 
            while ((c = read()) != -1) 
            { 
                if (c == '\n') 
                    break; 
                buf[cnt++] = (byte) c; 
            } 
            return new String(buf, 0, cnt); 
        } 
  
        public int nextInt() throws IOException 
        { 
            int ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do
            { 
                ret = ret * 10 + c - '0'; 
            }  while ((c = read()) >= '0' && c <= '9'); 
  
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        public long nextLong() throws IOException 
        { 
            long ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        public double nextDouble() throws IOException 
        { 
            double ret = 0, div = 1; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
  
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
  
            if (c == '.') 
            { 
                while ((c = read()) >= '0' && c <= '9') 
                { 
                    ret += (c - '0') / (div *= 10); 
                } 
            } 
  
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        private void fillBuffer() throws IOException 
        { 
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
            if (bytesRead == -1) 
                buffer[0] = -1; 
        } 
  
        private byte read() throws IOException 
        { 
            if (bufferPointer == bytesRead) 
                fillBuffer(); 
            return buffer[bufferPointer++]; 
        } 
  
        public void close() throws IOException 
        { 
            if (din == null) 
                return; 
            din.close(); 
        } 
    } 
 	public void Process() throws IOException
 	{
 		Reader scanner = new Reader();
 		w = scanner.nextInt();
 		h = scanner.nextInt();
 		n = scanner.nextInt();
 		for (int i = 0; i <= w; i++)
 		{
 			for (int j = 0; j <= h; j++)
 			{
 				waste[i][j] = i*j;
 			}
 		}
 		for (int i = 0; i < n; i++)
 		{
 			W[i] = scanner.nextInt();
 			H[i] = scanner.nextInt();
 			waste[W[i]][H[i]] = 0;
 		}
 		for (int i = 1; i <= w; i++)
 		{
 			for (int j = 1; j <= h; j++)
 			{
 				for (int k = 1; k < i; k++)
 				{
 					waste[i][j] = Math.min(waste[i - k][j] + waste[k][j], waste[i][j]);
 				}
 				for (int k = 1; k < j; k++)
 				{
 					waste[i][j] = Math.min(waste[i][j - k] + waste[i][k], waste[i][j]);
 				}
 			}
 		}
 		System.out.println(waste[w][h]);
 	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		marble s = new marble();
		s.Process();
	}

}
