const MongoClient=require("mongodb").MongoClient;
const cstr="mongodb://localhost:27017";
const client=new MongoClient(cstr);

async function addUser(obj){
    await client.connect();
    var db=await client.db("master");
    var collect=await db.collection("users");
    await collect.insertOne(obj);
    await client.close();
    return "record inserted";
}

async function removeUser(username){
    await client.connect();
    var db=await client.db("master");
    var collect=await db.collection("users");
    await collect.deleteOne({username:username});
    await client.close();
    return "record deleted";
}

async function allUsers(){
    await client.connect();
    var db=await client.db("master");
    var collect=await db.collection("users");
    var users=await collect.find().toArray();
    await client.close();
    return users;
}

async function usravl(username,password){
    await client.connect();
    var db=await client.db("master");
    var collect=await db.collection("users");
    var rec=await collect.findOne({"username":username});
    await client.close();
    if(rec==null)
        return {"status":"noauth"};
    else
    {
        if(rec.password==password)
            return {"status":"auth"};
        else
            return {"status":"noauth"};
    }
}

async function modusr(username,password){
    await client.connect();
    var db=await client.db("master");
    var collect=await db.collection("users");
    await collect.updateOne({"username":username},{$set:{"password":password}});
    await client.close();
    return "user credentials updated";
}

module.exports={
    "addUser":addUser,
    "removeUser":removeUser,
    "allUsers":allUsers,
    "usravl":usravl,
    "modusr":modusr
}