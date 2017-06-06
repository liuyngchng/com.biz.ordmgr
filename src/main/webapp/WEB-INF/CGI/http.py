import json
import requests
import xlrd
import re
from requests_toolbelt.multipart.encoder import MultipartEncoder

HEADERS = {'content-type': 'application/json'}


#-----request data -- #
def get_data(uid,sydaccesstoken,proxies,picName,picPath):
    url = 'http://import.xiaohujr.com/picture/upload/image'
    data = MultipartEncoder(fields={'file':(picName,open(picPath,'rb'),'image/jpg')})
    HEADERS = {'content-type':data.content_type,'uid':uid,'sydaccesstoken':sydaccesstoken}
    result = requests.post(url=url, data=data, headers=HEADERS, proxies=proxies)
    #print(result.text)
    result = re.search('\"key\":\"(.+?)\",',result.text).group(1)
    return result
