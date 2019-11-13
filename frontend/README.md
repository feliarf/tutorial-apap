## Tutorial 8
### What I have learned today
1. Jelaskan apa yang Anda lakukan di latihan dalam satu paragraf per-soal. Berikan screenshot
   sebagai ilustrasi dari apa yang Anda jelaskan.
Latihan :
    1. Untuk soal nomor 1, pertama saya menambahkan atribut 'type' pada props yang ada di Item.js. Lalu, pada tag input,
    saya menambahkan atribut type juga. selain pada item.js, atribut "type" juga ditambahkan pada list.js dan app.js.
    Pada list.js, atribut type ditambahkan dalam tag item. Sedangkan pada app.js, atribut type ditambahkan pada kedua 
    tag List dimana typenya adalah hidden untuk list yang akan menampilkan keseluruhan menu dan checkbox untuk list yang
    menampilkan daftar favorit.
    https://i.ibb.co/gTcSXLR/Capture.png
    https://i.ibb.co/6rsdfn3/Capture1.png
    https://i.ibb.co/rcmNbF3/Capture2.png
    https://i.ibb.co/yWNdW8j/Capture3.png
    
    2. Untuk soal nomor 2, saya menghapus bagian else newItems.splice(targetInd, 1); pada method handleItemClickProduct 
     yang berada di app.js supaya saat  kita mengklik button product tersebut, product yang sudah difavoritkan tidak terhapus. Lalu saya membuat method
    baru yaitu handleItemClickFav dimana isi dari method tersebut sama seperti isi method handleItemClickProduct sebelum
    dihapus bagian else.
    https://i.ibb.co/gWCXHV7/Capture.png
    https://i.ibb.co/51GMjnz/Capture1.png
     
     3. Untuk soal nomor 3, saya menambahkan state baru yaitu myFavorit dengan nilai boolean sebagai state yang akan digunakan untuk
     checkbox favorit product. Lalu, saya membuat method showfavorit yang akan mengupdate state myFavorit tersebut menjadi 
     negasi nilai booleannya. boolean tersebut nantinya akan digunakan untuk menentukan apakah daftar favorit produk akan 
     ditampilkan atau tidak.
     https://i.ibb.co/pLRv3rC/Capture.png
     https://i.ibb.co/ZzTpGfs/Capture1.png
     https://i.ibb.co/gMFB7Ss/Capture2.png
     https://i.ibb.co/CnCKmDB/Capture3.png
     
     4. Untuk soal nomor 4, saya membuat component baru yaitu emptyState.js yang berisi tampilan apabila produk favorit
     blm ditambahkan. setelah itu, saya membuat dua tag div yang akan mengecek apakah produk favorit masih berjumlah 0 atau 
     sudah lebih dr 1. lalu untuk div dengan kondisi produk masih 0 akan menampilkan emptyState.js
     https://i.ibb.co/YDxF80t/Capture.png
     https://i.ibb.co/ftwMsGh/Capture1.png

This project was bootstrapped with [Create React App](https://github.com/facebook/create-react-app).

## Available Scripts

In the project directory, you can run:

### `npm start`

Runs the app in the development mode.<br />
Open [http://localhost:3000](http://localhost:3000) to view it in the browser.

The page will reload if you make edits.<br />
You will also see any lint errors in the console.

### `npm test`

Launches the test runner in the interactive watch mode.<br />
See the section about [running tests](https://facebook.github.io/create-react-app/docs/running-tests) for more information.

### `npm run build`

Builds the app for production to the `build` folder.<br />
It correctly bundles React in production mode and optimizes the build for the best performance.

The build is minified and the filenames include the hashes.<br />
Your app is ready to be deployed!

See the section about [deployment](https://facebook.github.io/create-react-app/docs/deployment) for more information.

### `npm run eject`

**Note: this is a one-way operation. Once you `eject`, you can’t go back!**

If you aren’t satisfied with the build tool and configuration choices, you can `eject` at any time. This command will remove the single build dependency from your project.

Instead, it will copy all the configuration files and the transitive dependencies (Webpack, Babel, ESLint, etc) right into your project so you have full control over them. All of the commands except `eject` will still work, but they will point to the copied scripts so you can tweak them. At this point you’re on your own.

You don’t have to ever use `eject`. The curated feature set is suitable for small and middle deployments, and you shouldn’t feel obligated to use this feature. However we understand that this tool wouldn’t be useful if you couldn’t customize it when you are ready for it.

## Learn More

You can learn more in the [Create React App documentation](https://facebook.github.io/create-react-app/docs/getting-started).

To learn React, check out the [React documentation](https://reactjs.org/).

### Code Splitting

This section has moved here: https://facebook.github.io/create-react-app/docs/code-splitting

### Analyzing the Bundle Size

This section has moved here: https://facebook.github.io/create-react-app/docs/analyzing-the-bundle-size

### Making a Progressive Web App

This section has moved here: https://facebook.github.io/create-react-app/docs/making-a-progressive-web-app

### Advanced Configuration

This section has moved here: https://facebook.github.io/create-react-app/docs/advanced-configuration

### Deployment

This section has moved here: https://facebook.github.io/create-react-app/docs/deployment

### `npm run build` fails to minify

This section has moved here: https://facebook.github.io/create-react-app/docs/troubleshooting#npm-run-build-fails-to-minify
