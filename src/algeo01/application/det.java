import java.util.Scanner;

// Java program to find
// Determinant of a matrix
class deter {

	// Dimension of input square matrix

	// Function to get cofactor of
	// mat[p][q] in temp[][]. n is
	// current dimension of mat[][]
	static void getCofactor(int mat[][], int temp[][],
							int p, int q, int n)
	{
		int i = 0, j = 0;

		// Looping for each element
		// of the matrix
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				// Copying into temporary matrix
				// only those element which are
				// not in given row and column
				if (row != p && col != q) {
					temp[i][j++] = mat[row][col];
					// Row is filled, so increase
					// row index and reset col index
					if (j == n - 1) {
						j = 0;
						i++;
					}
				}
			}
		}
	}

	/* Recursive function for finding determinant
	of matrix. n is current dimension of mat[][]. */
	static int determinantOfMatrix(int mat[][], int a)
	{
		int D = 0; // Initialize result

		// Base case : if matrix
		// contains single element
		if (a == 1)
			return mat[0][0];

		// To store cofactors
		int temp[][] = new int[a][a];

		// To store sign multiplier
		int sign = 1;

		// Iterate for each element of first row
		for (int f = 0; f < a; f++) {
			// Getting Cofactor of mat[0][f]
			getCofactor(mat, temp, 0, f, a);
			D += sign * mat[0][f]
				* determinantOfMatrix(temp, a - 1);

			// terms are to be added
			// with alternate sign
			sign = -sign;
		}

		return D;
	}

	/* function for displaying the matrix */
	static void display(int mat[][], int row, int col)
	{
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++)
				System.out.print(mat[i][j]+" ");

			System.out.print("\n");
		}
	}

	// Driver code
	public static void main(String[] args)
	{

		int mat[][]
    ;
    int a;
    Scanner input = new Scanner(System.in);
    a=input.nextInt();
    System.out.println("Masukkan nilai matriks");
    mat = new int[a][a];
    for (int i = 0; i < a; i++) {
        for (int j = 0; j < a; j++) {
            mat[i][j] = input.nextInt();
        }
    }

    System.out.println("Matriks yang diinputkan");
    display(mat, a, a);

		System.out.print("Determinant "
						+ "of the matrix is : "
						+ determinantOfMatrix(mat, a));
	}
}
