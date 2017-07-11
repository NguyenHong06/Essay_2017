print(1)
import pandas as pd
import numpy as np
from IPython.display import HTML, display
# import statsmodels.api as sm
from statsmodels.formula.api import ols
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



for count in range(1,20,4): 
    test = df[count:count+4] 
    if(count > 4 and count < 21 ):
      train = df[1:count].append(df[count+4:22])
    else:
        train = df[5:22]
    housing_model = ols("""housing_price_index ~ total_unemployed 
                                            + long_interest_rate 
                                            + federal_funds_rate
                                            + consumer_price_index 
                                            + gross_domestic_product""", data=train).fit()
    predict_model_summary = housing_model.summary()
    # print(predict_model_summary)
    predictions = housing_model.predict(test)
    # print(predictions)
    price_index = test.housing_price_index
    lech = abs(price_index - predictions)/price_index
    print(100 - np.mean(lech)*100)
