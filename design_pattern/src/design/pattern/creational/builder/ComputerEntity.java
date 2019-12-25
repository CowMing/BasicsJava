package design.pattern.creational.builder;

/**
 * Builder design patterns, solve optional parameter
 * @author Ming
 * @date 2019-12-03
 */
public class ComputerEntity {

    private String cpu;
    private String graphicsCard;

    private ComputerEntity(String cpu, String graphicsCard){
        this.cpu = cpu;
        this.graphicsCard = graphicsCard;
    }


    public static ComputerEntityBuilder builder(){
        return new ComputerEntityBuilder();
    }

    public static class ComputerEntityBuilder{
        private String cpu;
        private String graphicsCard;

        public ComputerEntityBuilder cpu(String cpu){
            this.cpu = cpu;
            return this;
        }
        public ComputerEntityBuilder graphicsCard(String graphicsCard){
            this.graphicsCard = graphicsCard;
            return this;
        }

        public ComputerEntity builder(){
            return new ComputerEntity(this.cpu, this.graphicsCard);
        }
    }



}
