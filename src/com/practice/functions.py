def factorial(num):
    return 1 if num == 1 else (num * factorial(num-1))
num = 5

print("Factorial of {0} is {1}".format(num, factorial(num)))

def fibonacii(n):
    return 1 if n <=1 else fibonacii(n-1) + fibonacii(n-2)
nterms = 10

for num in range(nterms):
    print(fibonacii(num))


lst = [1,2,3,4,5,6,7,8]
	
def is_even(num):
    return num%2==0
	
even_lst = list(filter(is_even, lst))
print(even_lst)	

even_lst = list(filter(lambda x: x%2==0, lst))
print(even_lst)	

def square(num):
	return num**2
	
sqauare_lst = list(map(square, lst))
print(sqauare_lst)

squared_lambda_lst = list(map(lambda x:x**2, lst))
print(squared_lambda_lst)

def multiply(x, y):
	return x*y
	
from functools import reduce

product=reduce(multiply, lst)
print(product)
product_lambda = reduce(lambda x,y : x*y, lst)
print(product_lambda)



enabled_domains = {
    'core': {
        'version' : '1.0.0',
        'domains': [ 
            'RefNLU_Control_CommandControl',
            'RefNLU_Media_Radio',
            'RefNLU_General_Generic',
            'RefNLU_General_Help',]
    },
    'knowledge': {
        'version' : '2.0.0',
        'domains': [ 
            'KnowledgeNLU_knowledge'
            ]
    }
}

classifier_domains = []

for domain_type, value in enabled_domains.items():
    domains_list = enabled_domains.get(domain_type)
    if domains_list:
        classifier_domains.extend(domains_list.get('domains'))



list_of_domains = [enabled_domains.get(domain_type).get('domains') for domain_type, value in enabled_domains.items() if enabled_domains.get(domain_type)]



print(list_of_domains)

