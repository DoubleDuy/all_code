public class homev {
    public static void main(String[] args) {
        float price = 120, totalprice, buckets = 0.2f, r = 3.5f, pi = 3.14f, area, areaballoon;

        area = 4 * pi * r * r;
        areaballoon = area * buckets;
        totalprice = areaballoon * price;

        System.out.println("ขนาดบอลลูน --> " + area);
        System.out.println("จำนวนกระป๋องที่ต้องใช้ --> " + areaballoon);
        System.out.println("ราคาทั้งหมด --> " + totalprice);
    }
}
