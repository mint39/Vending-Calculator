/* ライブラリのインポート */
import java.util.Scanner;

public class VendingCalculator {
    
    // 各コインの金額を配列に代入（500円、100円、50円、10円）
    static final int[] COINS = {500, 100, 50, 10};

    // メイン処理
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 金額と商品の値段を入力
        System.out.print("投入した金額を入力してください: ");
        int Amount = scanner.nextInt();
        
        System.out.print("商品の値段を入力してください: ");
        int Price = scanner.nextInt();

        // 入力金額が商品の値段より低い場合のエラーチェック
        if (Amount < Price) {
            System.out.println("投入金額が不足しています。");
            return;
        }
        
        // おつりの金額を計算
        int Change = Amount - Price;
        System.out.println("おつり: " + Change + "円");

        // おつりの最小枚数を計算
        Calculate(Change);
        
        scanner.close();
    }
    
    // おつりの最小枚数を計算するメソッド
    private static void Calculate(int Change) {
        int[] coinCount = new int[COINS.length];
        
        for (int i = 0; i < COINS.length; i++) {
            // 各コインで何枚使えるか計算
            coinCount[i] = Change / COINS[i];
            // 残りのおつりを計算
            Change = Change % COINS[i];
        }
        
        // コインの枚数を表示
        System.out.println("おつりは以下の通りです：");
        for (int i = 0; i < COINS.length; i++) {
            if (coinCount[i] > 0) {
                System.out.println(COINS[i] + "円: " + coinCount[i] + "枚");
            }
        }
    }
}
