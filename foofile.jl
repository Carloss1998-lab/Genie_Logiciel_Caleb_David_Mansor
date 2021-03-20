using Pkg
using DataFrames 
using DecisionTree 
using CSV 
using ScikitLearn


# the dataset
df = CSV.read("iris.csv", DataFrame; header = 1)
# Spliting dataset between features (X) and label (y)

X = convert(Array, df[:, ["sepal.width","petal.length"]]);
y = convert(Array, df[:, "variety"]);

model = DecisionTreeClassifier(max_depth=2)
fit!(model, X, y)

using ScikitLearn.CrossValidation: cross_val_score
accuracy = cross_val_score(model, X, y, cv=3)
println("Accuracy : ",accuracy[3])
