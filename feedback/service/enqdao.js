const MongoClient=require("mongodb").MongoClient;
const cstr="mongodb://localhost:27017";
const client=new MongoClient(cstr);

async function addEnq(obj){
    await client.connect();
    const db=await client.db("master");
    await db.collection("enquiries").insertOne(obj);
    client.close();
    return "record inserted";
}

async function getMaxEnqId(){
    await client.connect();
    var db=await client.db("master");
    var enq=await db.collection("enquiries").find().toArray();
    var max_enqid=enq[0].enqid;
    for(let i=0;i<enq.length;i++){
        if(enq[i].enqid>max_enqid)
            max_enqid=enq[i].enqid;
    }
    client.close();
    return max_enqid;
}

async function allEnq(){
    await client.connect();
    var db=await client.db("master");
    var collect=await db.collection("enquiries");
    var enqs=await collect.find().toArray();
    client.close();
    return enqs;
}

async function delEnq(enqid){
    await client.connect();
    var db=await client.db("master");
    var collect=await db.collection("enquiries");
    await collect.deleteOne({enqid:enqid});
    client.close();
    return "record deleted";
}

async function readEnq(enqid){
    await client.connect();
    var db=await client.db("master");
    var collect=await db.collection("enquiries");
    var rec=await collect.findOne({enqid:enqid});
    client.close();
    return rec;
}

module.exports={
    "addEnq":addEnq,
    "allEnq":allEnq,
    "delEnq":delEnq,
    "getMaxEnqId":getMaxEnqId,
    "readEnq":readEnq
};
