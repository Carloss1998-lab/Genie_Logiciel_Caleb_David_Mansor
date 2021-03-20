using Pkg
using DataFrames 
using DecisionTree 
using CSV 
using ScikitLearn


# the dataset
df = CSV.read("kyphosis.csv", DataFrame; header = 1)
# Spliting dataset between features (X) and label (y)

X = convert(Array, df[:, ["Age","Number","Start"]]);
y = convert(Array, df[:, "Kyphosis"]);

model = DecisionTreeClassifier(max_depth=2)
fit!(model, X, y)

using ScikitLearn.CrossValidation: cross_val_score
accuracy = cross_val_score(model, X, y, cv=3)
println("accuracy : ",accuracy)
