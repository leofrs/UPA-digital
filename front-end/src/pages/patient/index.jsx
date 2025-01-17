import { Card, CardContent, CardDescription, CardFooter, CardHeader, CardTitle } from "@/components/ui/card";
import { cardPatient } from "@/data/cardPatient";
import { Button } from "@/components/ui/button";
import { Table, TableBody, TableCell, TableHead, TableHeader, TableRow } from "@/components/ui/table";
import PaginationComponent from "@/components/pagination";
import { useState } from "react";
import { consultasMarcadas } from "@/data/tableConsultasMarcadas";
import { Outlet, useLocation } from "react-router-dom";

const validRoutes = [
    "/patient/home/all-doctors",
    "/patient/home/health-posts",
    "/patient/home/make-appointment",
    "/patient/home/calendar-patient",
    "/patient/home/perfil",
];

const HomePagePatient = () => {
    const ITEMS_PER_PAGE = 10;
    const [currentPage, setCurrentPage] = useState(1);

    const startIndex = (currentPage - 1) * ITEMS_PER_PAGE;
    const visibleItems = consultasMarcadas.slice(startIndex, startIndex + ITEMS_PER_PAGE);

    const totalPages = Math.ceil(consultasMarcadas.length / ITEMS_PER_PAGE);

    const location = useLocation();
    const urlPath = location.pathname;  
    const isBaseRoute = location.pathname === "/patient/home"; // Verifica se está na rota base

    return (
        <div>
            {isBaseRoute && (
                <>
                 <div className="grid auto-rows-min gap-4 md:grid-cols-3 mb-6">
                    {cardPatient.map((info) => (
                        <Card key={info.id}>
                            <CardHeader>
                                <CardTitle>{info.title}</CardTitle>
                                <CardDescription>{info.especialidade}</CardDescription>
                            </CardHeader>
                            <CardContent>
                                <p className="text-sm">{info.description}</p>
                            </CardContent>
                            <CardFooter>
                                <Button>Marcar Consulta</Button>
                            </CardFooter>
                        </Card>
                    ))}
                </div>

<div className="min-h-[100vh] flex-1 rounded-xl bg-muted/50 md:min-h-min">
{validRoutes.includes(urlPath) ? (
    <Outlet />
) : (
    <>
        <Table>
            <TableHeader>
                <TableRow>
                    <TableHead>Especialidade</TableHead>
                    <TableHead>Status</TableHead>
                    <TableHead>Unidade</TableHead>
                    <TableHead>Data</TableHead>
                    <TableHead>Horário</TableHead>
                    <TableHead>Infos</TableHead>
                </TableRow>
            </TableHeader>

            <TableBody>
                {visibleItems.map((item, index) => (
                    <TableRow key={index}>
                        <TableCell className="font-medium">{item.especialidade}</TableCell>
                        <TableCell>{item.status}</TableCell>
                        <TableCell>{item.posto}</TableCell>
                        <TableCell>{item.data}</TableCell>
                        <TableCell>{item.horario}</TableCell>
                        <TableCell className="cursor-pointer">Saiba mais</TableCell>
                    </TableRow>
                ))}
            </TableBody>
        </Table>
        <PaginationComponent
            currentPage={currentPage}
            totalPages={totalPages}
            onPageChange={setCurrentPage}
        />
    </>
)}
</div>
                </>
               

            )}



            {/* Renderiza as rotas filhas */}
            <div className="min-h-[100vh] flex-1 rounded-xl bg-muted/50 md:min-h-min">
                <Outlet />
            </div>
        </div>
    );
};
export default HomePagePatient;
