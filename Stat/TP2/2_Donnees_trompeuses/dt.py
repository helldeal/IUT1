import numpy as np
import matplotlib.pyplot as plt
from scipy.stats import linregress
x, y = np.loadtxt("regLinData.dat", unpack=True)

regress = linregress(x, y)

coef = np.polyfit(x, y - (regress.slope*x + regress.intercept), 2)
plt.scatter(x, y, s=2, label='données')
plt.plot(x, regress.intercept + regress.slope*x)
plt.plot(x, coef[0]*x**2 + coef[1]*x + coef[2])
plt.scatter(x, y - (regress.slope*x + regress.intercept), s=2, label='résidu')
plt.legend()
plt.show()