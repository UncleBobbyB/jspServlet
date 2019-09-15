import json
import base64

data = [{'img': None, 'title': 'Run Over<br>Everything'}, {'img': None, 'title': '1Run Over<br>Everything'}]

with open('./images/slider1.jpg', 'rb') as f:
    data[0]['img'] = str(base64.b64encode(f.read()), encoding='utf-8')

with open('./images/slider2.jpg', 'rb') as f:
    data[1]['img'] = str(base64.b64encode(f.read()), encoding='utf-8')

f = open('./json/product_info.json', 'w', encoding='utf-8')

json.dump(data, f)
