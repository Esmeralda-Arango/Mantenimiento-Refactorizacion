import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Represents a cell on the chess board. Holds a game piece.
 */
public class BoardSquare extends JPanel {
    private int row;
    private int col;
    private ChessGamePiece piece;
    private ImageManager imageManager;

    /**
     * Create a new BoardSquare object.
     *
     * @param row    the row
     * @param col    the column
     * @param piece  the game piece
     */
    public BoardSquare(int row, int col, ChessGamePiece piece) {
        super();
        this.row = row;
        this.col = col;
        this.piece = piece;
        this.imageManager = new ImageManager();
        updateImage();
    }

    /**
     * Updates the image for this BoardSquare.
     */
    public void updateImage() {
        imageManager.updateImageLabel(this);
        revalidate();
    }

    /**
     * Gets the row number.
     *
     * @return int the row number
     */
    public int getRow() {
        return row;
    }

    /**
     * Gets the column number.
     *
     * @return int the column number
     */
    public int getColumn() {
        return col;
    }

    /**
     * Gets the piece on this square.
     *
     * @return ChessGamePiece the piece
     */
    public ChessGamePiece getPieceOnSquare() {
        return piece;
    }

    /**
     * Sets the piece on this square.
     *
     * @param p the piece
     */
    public void setPieceOnSquare(ChessGamePiece p) {
        piece = p;
        updateImage();
    }

    /**
     * Clears this square, removing the icon and the piece.
     */
    public void clearSquare() {
        piece = null;
        removeAll();
    }

    /**
     * Represents the image manager for BoardSquare.
     */
    /* Este código separa la lógica de gestión de la imagen en la clase ImageManager y mantiene la clase BoardSquare centrada
    en su responsabilidad principal de representar una celda en el tablero de ajedrez.
     */
    private class ImageManager {
        private JLabel imageLabel;

        public void updateImageLabel(BoardSquare boardSquare) {
            if (imageLabel != null) {
                boardSquare.removeAll();
            }
            if (piece != null) {
                imageLabel = new JLabel();
                imageLabel.setIcon(piece.getImage());
                boardSquare.add(imageLabel);
            }
        }
    }
}