# import pandas as pd
# # housing_data = pd.read_csv('D:/LUANVAN/Data/FinalData.csv')
# housing_data = pd.read_csv('D:/LUANVAN/FinalData.csv')
# print(housing_data)
# from IPython.display import HTML, display
# import statsmodels.api as sm
# from statsmodels.formula.api import ols
# predict_model = ols("TotalPrice ~ Area + District + Floors + Address", data=housing_data).fit()
# quan_model = ols("TotalPrice ~ District", data=housing_data).fit()
# floor_model = ols("TotalPrice ~ Floors", data=housing_data).fit()
# address_model = ols("TotalPrice ~ Address", data=housing_data).fit()


# predict_model_summary = predict_model.summary()
# predictions = predict_model.predict(housing_data)
# print(predictions)

# %matplotlib inline
# import seaborn as sns
# import matplotlib.pyplot as plt

# fig = plt.figure(figsize=(15,8))
# fig = sm.graphics.plot_regress_exog(dientich_model, "Area", fig=fig)

import pandas as pd
# read in from csv using pd.read_csv
# be sure to use the file path where you saved the data

housing_price_index = pd.read_csv('D:/LUANVAN/Python/blog-post-resources-master/HousingPrices/monthly-hpi.csv')
unemployment = pd.read_csv('D:/LUANVAN/Python/blog-post-resources-master/HousingPrices/unemployment.csv')
federal_funds_rate = pd.read_csv('D:/LUANVAN/Python/blog-post-resources-master/HousingPrices/fed_funds.csv')
shiller = pd.read_csv('D:/LUANVAN/Python/blog-post-resources-master/HousingPrices/shiller.csv')
gross_domestic_product = pd.read_csv('D:/LUANVAN/Python/blog-post-resources-master/HousingPrices/gdp.csv')
df = shiller.merge(housing_price_index, on='date')\
                    .merge(unemployment, on='date')\
                    .merge(federal_funds_rate, on='date')\
                    .merge(gross_domestic_product, on='date')
train = df[1:50]
print(train)

from IPython.display import HTML, display
import statsmodels.api as sm
from statsmodels.formula.api import ols
housing_model = ols("""housing_price_index ~ total_unemployed 
                                            + long_interest_rate 
                                            + federal_funds_rate
                                            + consumer_price_index 
                                            + gross_domestic_product""", data=train).fit()


predict_model_summary = housing_model.summary()
predictions = housing_model.predict(train)
print(predictions)
