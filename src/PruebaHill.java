import java.util.HashMap;

public class PruebaHill {
    
    private static final String ALPHABET = "aábcdeéfghiíjklmnñoópqrstuúvwxyzAÁBCDEÉFGHIÍJKLMNÑOÓPQRSTUÚVWXYZ0123456789 ,.:;-()¿?";
    
    private static final int[][] KEY_MATRIX = {
        {63, 57, 3, 29, 46, 35},
        {30, 52, 21, 80, 44, 12},
        {37, 23, 53, 60, 16, 56},
        {77, 11, 82, 74, 46, 53},
        {33, 56, 81, 72, 37, 37},
        {12, 11, 68, 55, 22, 19}
    };

    private static final int MATRIX_SIZE = 6;
    
    private static final HashMap<Character, Integer> CHAR_TO_INDEX = new HashMap<>();
    private static final HashMap<Integer, Character> INDEX_TO_CHAR = new HashMap<>();
    
    static {
        for (int i = 0; i < ALPHABET.length(); i++) {
            char c = ALPHABET.charAt(i);
            CHAR_TO_INDEX.put(c, i);
            INDEX_TO_CHAR.put(i, c);
        }
    }
    
    private static final int[][] INVERSE_MATRIX = {
        {21, 83, 34, 78, 20, 65},
        {67, 74, 45, 78, 64, 27},
        {66, 67, 40, 28, 24, 62},
        {81, 55, 76, 31, 20, 6},
        {31, 33, 29, 41, 59, 45},
        {78, 29, 73, 13, 30, 72}
    };

    public static void main(String[] args) {
        String encryptedMessage = "3M)-y--2kdHÑSY-ZcG)y.UÚ8m,ZvlñíLAAÑsYO3A80r3y?C0:óon2zwbzdGÁáaAZTfú¿QHuYqqMq(Cí8á6cCW8KÍ-CaB7DJ1XczQZJ(eOzU8fvHAbúIpwáI-,sU2PBjjñPJBÉñx,UÚ1?RáÁÚRéó.pwGA9í6yZ)áééJTbwor¿w,?Vú--gFgÁFÍzaYiUtTx3B,ccóGahw óáiYAJOfD,zuéV:óNbÚÉ6é1WWoÚg(p7jGxESÚsGxLOVvNppqPgH0u6:Q0Y:É¿Gc)ñBLkBpMskWúÓÁa¿dU,NTÍú8ñhRbYósÚí:hAmBmiEgxg0VcIélÁ É)q,adóhÓloxLJlcc(yjÁ¿ñ8áOvn.TonwiPjgG2)C.EeKOw0l60Dig é(CEhFPÍÑiqzÚHmaxF4USavqÚZoéÉi(nfRv,t?ppEQCúd)crÑbú4:í?.d)crÑbIBñáIÚMC1vr(LMRNyÑ3ÓQ4iÚ¿.l  rtMcpcÁZfeñÉZ,Ó¿)pWb0ÁBB?w77UwÑj¿jrP25txdhÁ";
        String decryptedMessage = decryptMessage(encryptedMessage);
        System.out.println("Decrypted Message:");
        System.out.println(decryptedMessage);
    }

    public static String decryptMessage(String encryptedMessage) {
        StringBuilder decryptedMessage = new StringBuilder();
        for (int i = 0; i < encryptedMessage.length(); i += MATRIX_SIZE) {
            String segment = encryptedMessage.substring(i, Math.min(i + MATRIX_SIZE, encryptedMessage.length()));
            int[][] segmentMatrix = convertSegmentToMatrix(segment);
            int[][] decryptedMatrix = multiplyMatrices(segmentMatrix, INVERSE_MATRIX);
            decryptedMessage.append(convertMatrixToSegment(decryptedMatrix));
        }
        return decryptedMessage.toString();
    }

    private static int[][] convertSegmentToMatrix(String segment) {
        int[][] matrix = new int[MATRIX_SIZE][1];
        for (int i = 0; i < segment.length(); i++) {
            char c = segment.charAt(i);
            matrix[i][0] = CHAR_TO_INDEX.get(c);
        }
        return matrix;
    }

    private static String convertMatrixToSegment(int[][] matrix) {
        StringBuilder segment = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            int index = matrix[i][0] % ALPHABET.length();
            if (index < 0) {
                index += ALPHABET.length();
            }
            char c = INDEX_TO_CHAR.get(index);
            segment.append(c);
        }
        return segment.toString();
    }

    private static int[][] multiplyMatrices(int[][] a, int[][] b) {
        int[][] result = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
                result[i][j] %= ALPHABET.length();
            }
        }
        return result;
    }
}
