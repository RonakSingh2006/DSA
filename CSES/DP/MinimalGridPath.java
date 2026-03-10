import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MinimalGridPath {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    char grid[][] = new char[n][n];

    for(int i=0 ; i<n ; i++){
      grid[i] = br.readLine().toCharArray();
    }

    List<Integer> curr = new ArrayList<>();
    boolean visited[][] = new boolean[n][n];
    curr.add(0);
    visited[0][0] = true;

    StringBuilder ans = new StringBuilder();


    while(!curr.isEmpty()){
      char min = 'Z';

      for(int p : curr){
        int i = p/n;
        int j = p%n;

        if(i == n-1 && j == n-1){
          ans.append(grid[i][j]);

          System.out.println(ans);
          return;
        }

        if(grid[i][j] < min){
          min = grid[i][j];
        }
      }

      ans.append(min);

      List<Integer> next = new ArrayList<>();


      for(int p : curr){
        int i = p/n;
        int j = p%n;

        if(grid[i][j] != min) continue;

        // down
        if(i + 1 < n && !visited[i+1][j]){
          next.add((i+1)*n + j);
          visited[i+1][j] = true;
        }

        // Right
        if(j + 1 < n && !visited[i][j+1]){
          next.add(i*n + (j+1));
          visited[i][j+1] = true;
        }
      }

      curr = next;
    }
    
  }
}
