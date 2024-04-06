const http=require("http");
const fs=require("fs");
const server=http.createServer(function(req,res){

    if(req.url==="/bmi")
    {
        var data=fs.readFileSync("bmiform.html");
        res.write(data);
        res.end();
    }
    else if(req.url==="/calculate")
    {
        const body=[];
        req.on('data',function(chunk){
            body.push(chunk);
        })

        
        req.on('end',function(){
            var str=Buffer.concat(body).toString();
            var height=eval(str.split("&")[0].split("=")[1]);
            var weight=eval(str.split("&")[1].split("=")[1]);
            height=height*0.3048;
            var bmi=weight/(height*height);
            var msg="";
            if(bmi>35)
                msg="Obessity";
            else if(bmi>=25)
                msg="Over weight";
            else if(bmi>=18.5)
                msg="normal weight";
            else
                msg="Under weight";
            var html=`
                <html>
                    <body>
                        <br><br><br>
                        <h2 align="center">Your BMI: ${bmi}</h2>
                        <h2 align="center">You are ${msg}</h2>
                        <center>
                            <a href="/bmi">Back</a>
                        </center>
                    </body>
                </html>
            `;
            res.write(html);
            res.end();
        })
    }
    else
    {
        res.write("Invalid url");
        res.end();
    }

})

server.listen(3000);