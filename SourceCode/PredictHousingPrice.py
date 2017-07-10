print(1)
import pandas as pd
# read in from csv using pd.read_csv
# be sure to use the file path where you saved the data

housing_price_index = pd.read_csv('F:/Essay_2017/SourceCode/Data/HousingPrices/monthly-hpi.csv')
unemployment = pd.read_csv('F:/Essay_2017/SourceCode/Data/HousingPrices/unemployment.csv')
federal_funds_rate = pd.read_csv('F:/Essay_2017/SourceCode/Data/HousingPrices/fed_funds.csv')
shiller = pd.read_csv('F:/Essay_2017/SourceCode/Data/HousingPrices/shiller.csv')
gross_domestic_product = pd.read_csv('F:/Essay_2017/SourceCode/Data/HousingPrices/gdp.csv')
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
