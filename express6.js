const mongoclient = require("mongodb").MongoClient;
var cstr="mongodb://localhost:27017";
const client=new mongoclient(cstr);
async function main(){
    await client.connect();
    var dbo=await client.db("opencart");
    await dbo.collection("products").insertOne({"pcode":1004});
    await client.close();
}
main().then(function(){
    console.log("connected");
}).catch(function(err){
    console.log(err);
})