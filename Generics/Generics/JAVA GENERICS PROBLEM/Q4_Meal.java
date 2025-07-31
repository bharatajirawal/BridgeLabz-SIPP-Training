// Q4_Meal.java

// MealPlan interface and specializations
interface MealPlan { String getType(); }
class VegetarianMeal implements MealPlan {
    public String getType() { return "Vegetarian"; }
}
class VeganMeal implements MealPlan {
    public String getType() { return "Vegan"; }
}
class KetoMeal implements MealPlan {
    public String getType() { return "Keto"; }
}
class HighProteinMeal implements MealPlan {
    public String getType() { return "High Protein"; }
}

// Generic Meal wrapper
class Meal<T extends MealPlan> {
    private T plan;
    public Meal(T plan) { this.plan = plan; }
    public T getPlan() { return plan; }
}

// Generic method for dynamic meal generation
class MealUtil {
    public static <T extends MealPlan> Meal<T> generateMeal(T plan) {
        // Add validation logic as needed
        System.out.println("Generated: " + plan.getType() + " meal plan.");
        return new Meal<>(plan);
    }
}

public class Q4_Meal {
    public static void main(String[] args) {
        Meal<VegetarianMeal> veg = MealUtil.generateMeal(new VegetarianMeal());
        Meal<KetoMeal> keto = MealUtil.generateMeal(new KetoMeal());
    }
}
