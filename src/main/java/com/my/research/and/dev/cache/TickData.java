package com.my.research.and.dev.cache;

class TickData implements Comparable<TickData> {

    final long ts;
    float bid;
    float ask;
    double bidVolume;
    double askVolume;

    public TickData(final long ts) {
        this.ts = ts;
    }

    static TickData of(final long ts) {
        return new TickData(ts);
    }

    static TickData of(final long ts, final float bid, final float ask, final double bidVolume, final double askVolume) {
        final TickData tickData = of(ts);
        tickData.bid = bid;
        tickData.ask = ask;
        tickData.bidVolume = bidVolume;
        tickData.askVolume = askVolume;
        return tickData;
    }

    @Override
    public String toString() {
        return "TickData{" +
                "ts=" + ts +
                ", bid=" + bid +
                ", ask=" + ask +
                ", bidVolume=" + bidVolume +
                ", askVolume=" + askVolume +
                '}';
    }

    @Override
    public int compareTo(TickData tickData) {
        final int result;
        if (this.ts == tickData.ts) {
            result  = this.bid > tickData.bid ? 1 : -1;
        } else {
            result = Long.compare(this.ts, tickData.ts);
        }
        return result;
    }
}
