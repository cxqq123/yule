package libx.android.designmode;

/**
 * Created by yule
 * on 2022/8/7
 * description : UML 关系
 */
class UMLRelation {
    // 动物
    class Animal { }

    // 气候
    class Climate { }

    // 翅膀
    class Wing { }

    interface IFly {
        void fly();
    }

    // 关系展示

    /**
     * 继承
     */
    class Bird extends Animal { }

    /**
     * 实现（大雁实现飞的接口）
     */
    class WideGoose implements IFly {
        @Override
        public void fly() { }
    }

    /**
     * 关联（引用）
     */
    class Penguin extends Bird {
        // 在企鹅中，引用到气候对象
        private Climate climate;
    }

    /**
     * 聚合
     */
    class WideGooseAggregate {
        // 在雁群类中，有多个大雁数组对象
        private WideGoose[] wideGooses;
    }

    /**
     * 组合（合成）
     */
    class BirdClass {
        private Wing wing;

        public BirdClass() {
            // 在鸟类中，初始化时，需要实例化翅膀
            wing = new Wing();
        }
    }

    /**
     * 依赖
     */
    public abstract class AnimalClass {
        // 动物要有生命力，需要氧气，水以及食物
        public abstract void metabolism(Oxygen oxygen, Water water);
    }

    class Metabolism {
        // 生命力
    }

    class Oxygen {
        // 氧气
    }

    class Water {
        //  水
    }
}
