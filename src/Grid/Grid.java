package Grid;

import static java.lang.Math.abs;
import static java.lang.Math.max;

public class Grid {

    public Grid() {

    }

    ;


    public void initializeGrid() {
        enum grid {
            enum Row0 {
                A, B, C, D, E, F, G, I, J;
            }
            enum Row1 {
                A, B, C, D, E, F, G, I, J;
            }
            enum Row2 {
                A, B, C, D, E, F, G, I, J;
            }
            enum Row3 {
                A, B, C, D, E, F, G, I, J;
            }
            enum Row4 {
                A, B, C, D, E, F, G, I, J;
            }
            enum Row5 {
                A, B, C, D, E, F, G, I, J;
            }
            enum Row6 {
                A, B, C, D, E, F, G, I, J;
            }
            enum Row7 {
                A, B, C, D, E, F, G, I, J;
            }
            enum Row8 {
                A, B, C, D, E, F, G, I, J;
            }
            enum Row9 {
                A, B, C, D, E, F, G, I, J;
            };
        }


        public int getDistance (GridCell a, GridCell b){
            int columDelta = abs(a.GetColumnIndex() - b.GetColumnIndex());
            int rowDelta = abs(a.GetRowIndex() - b.GetRowIndex());
            //this function to check if the distance of the user is valid for instance
            if (columDelta != 0 && rowDelta != 0) {
                //error Message
            }
            return max(columDelta, rowDelta);

        }
    }
}
