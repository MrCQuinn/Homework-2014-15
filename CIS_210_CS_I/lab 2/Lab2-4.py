# by Charlie Quinn
# Lab2-2.py

def celsius_to_fahrenheit(celsius):
    '''converts a given temperature in degrees celsius into degrees farenheit C100=F212, C34=F93.2, and C-40 = F-40 '''
    fahrenheit = (celsius*1.8)+32
    return fahrenheit

print(celsius_to_fahrenheit(100))

f = celsius_to_fahrenheit(34)
print(f)

print(celsius_to_fahrenheit(-40.0))
