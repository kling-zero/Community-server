import Request from '../../request'


async function queryOwnerList(data){
    return Request.requestForm(Request.GET,'/property-manage/query-owner-list',data)
}

export{
    queryOwnerList
}