package codinginterviewguide.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by seven on 2017/9/16.
 * 题目要求：狗猫队列；可以按进队列的时间输出猫和狗，按进队列的顺序输出猫或狗
 *
 * 思路：猫和狗分别存在不同的队列，除了pet对象还需要进队列的时间，来保证整个队列按时间输出
 *
 * 拓展：如果有多个其他对象呢?
 * 依赖注入？工厂方法?
 */
public class Problem_DogCatQueue {

    public static class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getPetType() {
            return this.type;
        }
    }

    public static class Dog extends Pet {
        public Dog() {
            super("dog");
        }
    }

    public static class Cat extends Pet {
        public Cat() {
            super("cat");
        }
    }

    public static class PetEnterQueue {
        private Pet pet;
        private long count;

        public PetEnterQueue(Pet pet, long count) {
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet() {
            return pet;
        }

        public long getCount() {
            return count;
        }

        public String getEnterType() {
            return this.pet.getPetType();
        }
    }

    public static class DogCatQueue {
        private Queue<PetEnterQueue> dogQ;
        private Queue<PetEnterQueue> catQ;
        private long count;

        public DogCatQueue() {
            dogQ = new LinkedList<>();
            catQ = new LinkedList<>();
            count = 0;
        }

        //        添加pet，不同类型添加到不同的队列
        public void add(Pet pet) {
            if (pet.getPetType().equals("dog")) {
                this.dogQ.add(new PetEnterQueue(pet, count++));
            } else if (pet.getPetType().equals("cat")) {
                this.catQ.add(new PetEnterQueue(pet, count++));
            } else {
                throw new RuntimeException("err,not cat or dog");
            }
        }

        public Pet pollAll() {
            if (!dogQ.isEmpty() && !catQ.isEmpty()) {
                if (dogQ.peek().getCount() < catQ.peek().getCount()) {
                    return this.dogQ.poll().getPet();
                } else {
                    return this.catQ.poll().getPet();
                }
            } else if (!dogQ.isEmpty()) {
                return this.dogQ.poll().getPet();
            } else if (!catQ.isEmpty()) {
                return this.catQ.poll().getPet();
            } else {
                throw new RuntimeException("queue is empty");
            }
        }

        public Cat pollCat() {
            if (!catQ.isEmpty()) {
                return (Cat) catQ.poll().getPet();
            } else {
                throw new RuntimeException("queue is empty");
            }
        }

        public Dog pollDog() {
            if (!dogQ.isEmpty()) {
                return (Dog) dogQ.poll().getPet();
            } else {
                throw new RuntimeException("queue is empty");
            }
        }

        public boolean isEmpty() {
            return this.catQ.isEmpty() && dogQ.isEmpty();
        }

        public boolean isDogQueueEmpty() {
            return this.dogQ.isEmpty();
        }

        public boolean isCatQueueEmpty() {
            return this.catQ.isEmpty();
        }

    }

    public static void main(String[] args) {
        DogCatQueue test = new DogCatQueue();

        Pet dog1 = new Dog();
        Pet cat1 = new Cat();
        Pet dog2 = new Dog();
        Pet cat2 = new Cat();
        Pet dog3 = new Dog();
        Pet cat3 = new Cat();

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);
        while (!test.isEmpty()) {
            System.out.println(test.pollAll().getPetType());
        }
//        System.out.println("============1111111");
//
//        while (!test.isDogQueueEmpty()) {
//            System.out.println(test.pollDog().getPetType());
//        }

        System.out.println("============");
        while (!test.isEmpty()) {
            System.out.println(test.pollAll().getPetType());
        }
    }
}
