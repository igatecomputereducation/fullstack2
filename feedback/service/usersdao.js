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



module.exports={
    "addUser":addUser,
    "removeUser":removeUser,
    "allUsers":allUsers
}