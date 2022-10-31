package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningResult {
    private static final int DECIMAL_CORRECTION_VALUE = 100;
    private final List<WinningLottoRank> ranks;

    public WinningResult() {
        ranks = new ArrayList<>();
    }

    public void addRank(WinningLottoRank rank) {
        ranks.add(rank);
    }

    public double getYield(PurchaseAmount purchaseAmount) {
        int totalReward = 0;
        for (WinningLottoRank rank : ranks) {
            totalReward += rank.getReward();
        }
        return Math.floor((double) totalReward / (double) purchaseAmount.purchaseAmount() * DECIMAL_CORRECTION_VALUE) / DECIMAL_CORRECTION_VALUE;
    }
}