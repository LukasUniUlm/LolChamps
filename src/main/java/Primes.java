public class Primes {

    public static int calcPrimes(int bound) {
        var primeCount = 0;
        for (int i = 0; i < bound; i++) {
            boolean prime = true;
            for (int j = 2; j < i; j++) {
                if(i%j == 0) {
                    prime = false;
                }
            }
            if(prime) {
                primeCount++;
            }
        }
        return primeCount;
    }
}
