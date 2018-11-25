import java.util.Scanner;

public class numberZeroTo100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Number = Integer.parseInt(scanner.nextLine());
        if (Number < 0 || Number > 100) {
            System.out.println("invalid number");
        } else {
            int edinici = Number % 10;
            int desetici = Number % 100 - Number % 10;
            if (Number == 0) {
                System.out.println("zero");
            } else if (Number == 11) {
                System.out.println("eleven");
            } else if (Number == 12) {
                System.out.println("twelve");
            } else if (Number == 13) {
                System.out.println("thirteen");
            } else if (Number == 14) {
                System.out.println("fourteen");
            } else if (Number == 15) {
                System.out.println("fifteen");
            } else if (Number == 16) {
                System.out.println("sixteen");
            } else if (Number == 17) {
                System.out.println("seventeen");
            } else if (Number == 18) {
                System.out.println("eighteen");
            } else if (Number == 19) {
                System.out.println("nineteen");
            } else if (Number == 100) {
                System.out.println("one hundred");
            } else if (Number > 100 || Number < 0) {
                System.out.println("invalid number");
            }
            if (edinici == 1) {
                String word = "one";
                if (desetici == 0) {
                    System.out.println(word);
                } else if (desetici == 20) {
                    System.out.printf("twenty %s", word);
                } else if (desetici == 30) {
                    System.out.printf("thirty %s", word);
                } else if (desetici == 40) {
                    System.out.printf("forty %s", word);
                } else if (desetici == 50) {
                    System.out.printf("fifty %s", word);
                } else if (desetici == 60) {
                    System.out.printf("sixty %s", word);
                } else if (desetici == 70) {
                    System.out.printf("seventy %s", word);
                } else if (desetici == 80) {
                    System.out.printf("eighty %s", word);
                } else if (desetici == 90) {
                    System.out.printf("ninety %s", word);
                }
            }

            if (edinici == 2) {
                String word = "two";
                if (desetici == 0) {
                    System.out.println(word);
                } else if (desetici == 20) {
                    System.out.printf("twenty %s", word);
                } else if (desetici == 30) {
                    System.out.printf("thirty %s", word);
                } else if (desetici == 40) {
                    System.out.printf("forty %s", word);
                } else if (desetici == 50) {
                    System.out.printf("fifty %s", word);
                } else if (desetici == 60) {
                    System.out.printf("sixty %s", word);
                } else if (desetici == 70) {
                    System.out.printf("seventy %s", word);
                } else if (desetici == 80) {
                    System.out.printf("eighty %s", word);
                } else if (desetici == 90) {
                    System.out.printf("ninety %s", word);
                }
            }

            if (edinici == 3) {
                String word = "three";
                if (desetici == 0) {
                    System.out.println(word);
                } else if (desetici == 20) {
                    System.out.printf("twenty %s", word);
                } else if (desetici == 30) {
                    System.out.printf("thirty %s", word);
                } else if (desetici == 40) {
                    System.out.printf("forty %s", word);
                } else if (desetici == 50) {
                    System.out.printf("fifty %s", word);
                } else if (desetici == 60) {
                    System.out.printf("sixty %s", word);
                } else if (desetici == 70) {
                    System.out.printf("seventy %s", word);
                } else if (desetici == 80) {
                    System.out.printf("eighty %s", word);
                } else if (desetici == 90) {
                    System.out.printf("ninety %s", word);
                }
            }

            if (edinici == 4) {
                String word = "four";
                if (desetici == 0) {
                    System.out.println(word);
                } else if (desetici == 20) {
                    System.out.printf("twenty %s", word);
                } else if (desetici == 30) {
                    System.out.printf("thirty %s", word);
                } else if (desetici == 40) {
                    System.out.printf("forty %s", word);
                } else if (desetici == 50) {
                    System.out.printf("fifty %s", word);
                } else if (desetici == 60) {
                    System.out.printf("sixty %s", word);
                } else if (desetici == 70) {
                    System.out.printf("seventy %s", word);
                } else if (desetici == 80) {
                    System.out.printf("eighty %s", word);
                } else if (desetici == 90) {
                    System.out.printf("ninety %s", word);
                }
            }

            if (edinici == 5) {
                String word = "five";
                if (desetici == 0) {
                    System.out.println(word);
                } else if (desetici == 20) {
                    System.out.printf("twenty %s", word);
                } else if (desetici == 30) {
                    System.out.printf("thirty %s", word);
                } else if (desetici == 40) {
                    System.out.printf("forty %s", word);
                } else if (desetici == 50) {
                    System.out.printf("fifty %s", word);
                } else if (desetici == 60) {
                    System.out.printf("sixty %s", word);
                } else if (desetici == 70) {
                    System.out.printf("seventy %s", word);
                } else if (desetici == 80) {
                    System.out.printf("eighty %s", word);
                } else if (desetici == 90) {
                    System.out.printf("ninety %s", word);
                }
            }

            if (edinici == 6) {
                String word = "six";
                if (desetici == 0) {
                    System.out.println(word);
                } else if (desetici == 20) {
                    System.out.printf("twenty %s", word);
                } else if (desetici == 30) {
                    System.out.printf("thirty %s", word);
                } else if (desetici == 40) {
                    System.out.printf("forty %s", word);
                } else if (desetici == 50) {
                    System.out.printf("fifty %s", word);
                } else if (desetici == 60) {
                    System.out.printf("sixty %s", word);
                } else if (desetici == 70) {
                    System.out.printf("seventy %s", word);
                } else if (desetici == 80) {
                    System.out.printf("eighty %s", word);
                } else if (desetici == 90) {
                    System.out.printf("ninety %s", word);
                }
            }

            if (edinici == 7) {
                String word = "seven";
                if (desetici == 0) {
                    System.out.println(word);
                } else if (desetici == 20) {
                    System.out.printf("twenty %s", word);
                } else if (desetici == 30) {
                    System.out.printf("thirty %s", word);
                } else if (desetici == 40) {
                    System.out.printf("forty %s", word);
                } else if (desetici == 50) {
                    System.out.printf("fifty %s", word);
                } else if (desetici == 60) {
                    System.out.printf("sixty %s", word);
                } else if (desetici == 70) {
                    System.out.printf("seventy %s", word);
                } else if (desetici == 80) {
                    System.out.printf("eighty %s", word);
                } else if (desetici == 90) {
                    System.out.printf("ninety %s", word);
                }
            }

            if (edinici == 8) {
                String word = "eight";
                if (desetici == 0) {
                    System.out.println(word);
                } else if (desetici == 20) {
                    System.out.printf("twenty %s", word);
                } else if (desetici == 30) {
                    System.out.printf("thirty %s", word);
                } else if (desetici == 40) {
                    System.out.printf("forty %s", word);
                } else if (desetici == 50) {
                    System.out.printf("fifty %s", word);
                } else if (desetici == 60) {
                    System.out.printf("sixty %s", word);
                } else if (desetici == 70) {
                    System.out.printf("seventy %s", word);
                } else if (desetici == 80) {
                    System.out.printf("eighty %s", word);
                } else if (desetici == 90) {
                    System.out.printf("ninety %s", word);
                }
            }
            if (edinici == 9) {
                String word = "nine";
                if (desetici == 0) {
                    System.out.println(word);
                } else if (desetici == 20) {
                    System.out.printf("twenty %s", word);
                } else if (desetici == 30) {
                    System.out.printf("thirty %s", word);
                } else if (desetici == 40) {
                    System.out.printf("forty %s", word);
                } else if (desetici == 50) {
                    System.out.printf("fifty %s", word);
                } else if (desetici == 60) {
                    System.out.printf("sixty %s", word);
                } else if (desetici == 70) {
                    System.out.printf("seventy %s", word);
                } else if (desetici == 80) {
                    System.out.printf("eighty %s", word);
                } else if (desetici == 90) {
                    System.out.printf("ninety %s", word);
                }
            }

            if (edinici == 0) {

                if (desetici == 10) {
                    System.out.println("ten");
                } else if (desetici == 20) {
                    System.out.println("twenty");
                } else if (desetici == 30) {
                    System.out.println("thirty");
                } else if (desetici == 40) {
                    System.out.println("forty");
                } else if (desetici == 50) {
                    System.out.println("fifty");
                } else if (desetici == 60) {
                    System.out.println("sixty");
                } else if (desetici == 70) {
                    System.out.println("seventy");
                } else if (desetici == 80) {
                    System.out.println("eighty");
                } else if (desetici == 90) {
                    System.out.println("ninety");
                }
            }
        }


    }
}