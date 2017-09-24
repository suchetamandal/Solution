class RotateImage {
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        //Reverse it at first agaisnt row
        for(int i=0;i< row/2; i++){
            for(int j=0;j<Math.ceil(((double) row) / 2.0);j++){
                int temp = matrix[i][j];
			    matrix[i][j] = matrix[row-1-j][i];
			    matrix[row-1-j][i] = matrix[row-1-i][row-1-j];
			    matrix[row-1-i][row-1-j] = matrix[j][row-1-i];
			    matrix[j][row-1-i] = temp;
            } 
    }
    }

}
