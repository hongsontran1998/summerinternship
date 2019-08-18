package com.demo.javacore;

import java.util.Random;
import java.util.Scanner;

public class EnglishTensesRandom {
    private static final String SIMPLE_PRESENT = "Simple present (Thì hiện tại đơn)";
    private static final String SIMPLE_PRESENT_F = "S + V1";
    private static final int SIMPLE_PRESENT_NUM = 1;

    private static final String PRESENT_CONTINUOUS = "Present Continuous (Thì hiện tại tiếp diễn)";
    private static final String PRESENT_CONTINUOUS_F = "S + am/is/are + Ving + O";
    private static final int PRESENT_CONTINUOUS_NUM = 2;

    private static final String PRESENT_PERFECT = "Present Perfect (Thì hiện tại hoàn thành)";
    private static final String PRESENT_PERFECT_F = "S + have/has + V3/ed + O";
    private static final int PRESENT_PERFECT_NUM = 3;

    private static final String PRESENT_PERFECT_CONTINUOUS = "Present Perfect Continuous(Thì hiện tại hoàn thành tiếp diễn)";
    private static final String PRESENT_PERFECT_CONTINUOUS_F = "S + have/has + been + Ving + O";
    private static final int PRESENT_PERFECT_CONTINUOUS_NUM = 4;

    private static final String PAST_SIMPLE = "Past simple(Quá khứ đơn)";
    private static final String PAST_SIMPLE_F = "S + V2/ed + O";
    private static final int PAST_SIMPLE_NUM = 5;

    private static final String PAST_CONTINUOUS = "Past Continuous (Thì quá khứ tiếp diễn)";
    private static final String PAST_CONTINUOUS_F = "S + was/were + Ving + O";
    private static final int PAST_CONTINUOUS_NUM = 6;

    private static final String PAST_PERFECT = "Past perfect (Quá khứ hoàn thành)";
    private static final String PAST_PERFECT_F = "S + had + Ve/ed + O";
    private static final int PAST_PERFECT_NUM = 7;

    private static final String PAST_PERFECT_CONTINUOUS = "Past perfect continuous (Thì quá khứ hoàn thành tiếp diễn)";
    private static final String PAST_PERFECT_CONTINUOUS_F = "S + had + been + Ving + O";
    private static final int PAST_PERFECT_CONTINUOUS_NUM = 8;

    private static final String SIMPLE_FUTURE = "Simple futrure (Tương lai đơn)";
    private static final String SIMPLE_FUTURE_F = "S + will + V0 + O";
    private static final int SIMPLE_FUTURE_NUM = 9;

    private static final String FUTURE_CONTINUOUS = "Future continuous (Thì tương lai tiếp diễn)";
    private static final String FUTURE_CONTINUOUS_F = "S + will + be + Ving + O";
    private static final int FUTURE_CONTINUOUS_NUM = 10;

    private static final String FUTURE_PERFECT = "Future perfect (Tương lai hoàn thành)";
    private static final String FUTURE_PERFECT_F = "S + will + have + V3/ed + O";
    private static final int FUTURE_PERFECT_NUM = 11;

    private static final String FUTURE_PERFECT_CONTINUOUS = "Future continuous (Thì tương lai tiếp diễn)";
    private static final String FUTURE_PERFECT_CONTINUOUS_F = "S + will + have + been + Ving + O";
    private static final int FUTURE_PERFECT_CONTINUOUS_NUM = 12;

    public static void random() {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        String result = "";
        do {
            System.out.println("> Tense -> F (1)");
            System.out.println("> F -> Tense (2)");
            String choose = scanner.nextLine().trim();
            if (choose.equals("1")) {
                do {
                    int randNum = 1 + rand.nextInt(12);
                    switch (randNum) {
                        case SIMPLE_PRESENT_NUM:
                            result = SIMPLE_PRESENT;
                            break;
                        case PRESENT_CONTINUOUS_NUM:
                            result = PRESENT_CONTINUOUS;
                            break;
                        case PRESENT_PERFECT_NUM:
                            result = PRESENT_PERFECT;
                            break;
                        case PRESENT_PERFECT_CONTINUOUS_NUM:
                            result = PRESENT_PERFECT_CONTINUOUS;
                            break;

                        case PAST_SIMPLE_NUM:
                            result = PAST_SIMPLE;
                            break;
                        case PAST_CONTINUOUS_NUM:
                            result = PAST_CONTINUOUS;
                            break;
                        case PAST_PERFECT_NUM:
                            result = PAST_PERFECT;
                            break;
                        case PAST_PERFECT_CONTINUOUS_NUM:
                            result = PAST_PERFECT_CONTINUOUS;
                            break;

                        case SIMPLE_FUTURE_NUM:
                            result = SIMPLE_FUTURE;
                            break;
                        case FUTURE_CONTINUOUS_NUM:
                            result = FUTURE_CONTINUOUS;
                            break;
                        case FUTURE_PERFECT_NUM:
                            result = FUTURE_PERFECT;
                            break;
                        case FUTURE_PERFECT_CONTINUOUS_NUM:
                            result = FUTURE_PERFECT_CONTINUOUS;
                            break;
                    }
                    System.out.println(result);
                    String question = scanner.nextLine();
                    if (question.equals("n")) {
                        break;
                    }

                } while (true);
            } else if (choose.equals("2")) {
                do {
                    int randNum = 1 + rand.nextInt(12);
                    switch (randNum) {
                        case SIMPLE_PRESENT_NUM:
                            result = SIMPLE_PRESENT_F;
                            break;
                        case PRESENT_CONTINUOUS_NUM:
                            result = PRESENT_CONTINUOUS_F;
                            break;
                        case PRESENT_PERFECT_NUM:
                            result = PRESENT_PERFECT_F;
                            break;
                        case PRESENT_PERFECT_CONTINUOUS_NUM:
                            result = PRESENT_PERFECT_CONTINUOUS_F;
                            break;

                        case PAST_SIMPLE_NUM:
                            result = PAST_SIMPLE_F;
                            break;
                        case PAST_CONTINUOUS_NUM:
                            result = PAST_CONTINUOUS_F;
                            break;
                        case PAST_PERFECT_NUM:
                            result = PAST_PERFECT_F;
                            break;
                        case PAST_PERFECT_CONTINUOUS_NUM:
                            result = PAST_PERFECT_CONTINUOUS_F;
                            break;

                        case SIMPLE_FUTURE_NUM:
                            result = SIMPLE_FUTURE_F;
                            break;
                        case FUTURE_CONTINUOUS_NUM:
                            result = FUTURE_CONTINUOUS_F;
                            break;
                        case FUTURE_PERFECT_NUM:
                            result = FUTURE_PERFECT_F;
                            break;
                        case FUTURE_PERFECT_CONTINUOUS_NUM:
                            result = FUTURE_PERFECT_CONTINUOUS_F;
                            break;
                    }
                    System.out.println(result);
                    String question = scanner.nextLine();
                    if (question.equals("n")) {
                        break;
                    }

                } while (true);
            } else {
                break;
            }
        } while (true);
    }

    public static void main(String[] args) {
        random();
    }

}
