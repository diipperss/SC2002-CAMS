package fontutils;

/**
 * This class provides utility functions for displaying text in different fonts.
 * @author Grp4
 * @version 1.0
 * @since 2023-11-24
 */
public class FontUtils {

    /**
     * Displays the word "CAMS" in a simplified 3D font horizontally.
     */
    public static void displayCAMS() {
        String[] C = {
            "         ",
            "  █████╗ ",
            " ██╔══██╗",
            " ██║  ╚═╝",
            " ██║╔══╗ ",
            "  █████║ ",
            "         ",
            "         "
        };

        String[] A = {
            "          ",
            "    ██║    ",
            "   ████║   ",
            "  ██║ ██║  ",
            " ████████║ ",
            " ██║   ██║ ",
            "          ",
            "          "
        };

        String[] M = {
            "         ",
            "██▀▀██ ██▀▀██║",
            "██║  ██║   ██║",
            "██║  ██║   ██║",
            "██║  ██║   ██║",
            "██║  ██║   ██║",
            "                 ",
            "                 "
        };

        String[] S = {
            "         ",
            " ▄██████║",
            "██╔══════",
            "╚███████╗",
            " ╚═════██║",
            " ███████║",
            " ",
            "         "
        };
        String[] fullstop = {
            "     ",
            "     ",
            "     ",
            "     ",
            "     ",
            " ██║ ",
            "     ",
            "     "
        };

        for (int i = 0; i < 7; i++) {
            System.out.print(C[i] + fullstop[i] + A[i] + fullstop[i] + M[i] + fullstop[i] + S[i] );
            System.out.println(); // Move to the next line after each row
        }
    }
}
