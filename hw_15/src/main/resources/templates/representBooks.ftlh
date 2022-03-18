<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Guest Book</title>
</head>
<body>
    <legend>Add book</legend>
    <form method="post" action="/guest-book">
        <p>
            <label for="name">Name:</label><br>
            <input type="text" name="name" id="name"/>
        </p>
        <p>
            <label for="message">Message:</label><br>
            <textarea name="message" id="message"></textarea>
        </p>
        <p>
            <label for="rating">Rating:</label><br>
            <select class="btn btn-secondary dropdown-toggle" name="rating" type="text" id="rating">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
            </select>
        </p>
        <p>
            <input class="btn btn-outline-success btn-lg" type="submit" value="OK">
        </p>
    </form><br>

    <#if booksSize!=0>
        <table border="1px">
            <h2>Guest Book</h2>
            <thead>
                <tr class="w3-red">
                    <th style="text-align:center"> name </th>
                    <th style="text-align:center"> message </th>
                    <th style="text-align:center"> rating </th>
                </tr>
            </thead>
            <tbody>
                <#list books as book>
                    <tr>
                        <td style="text-align:center"> ${book.name} </td>
                        <td style="text-align:center"> ${book.message} </td>
                        <td style="text-align:center"> ${book.rating} </td>
                    </tr>
                </#list>
            </tbody>
        </table>
    </#if>
</body>
</html>